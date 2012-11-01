
package museu.sinbio_beta.maintaining;

import java.util.ArrayList;

import nu.xom.Element;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.R;
import museu.sinbio_beta.common.animation.managers.HiddenFlipper;
import museu.sinbio_beta.common.composite.GenericAdapter;
import museu.sinbio_beta.common.composite.GenericItemList;
import museu.sinbio_beta.common.filesystem.SdcardManager;
import museu.sinbio_beta.common.xml.pojo.RegisterXml;
import museu.sinbio_beta.creating.CreateRegisterActivity;
import museu.sinbio_beta.creating.sub_activitys.photo.CreatingAlbumManager;
import museu.sinbio_beta.creating.sub_activitys.xml.CreatingRegisterXMLManager;
import museu.sinbio_beta.maintaining.photo.EditingAlbumManager;
import museu.sinbio_beta.maintaining.xml.EditingRegisterXMLManager;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MaintainRegisterActivity extends Activity
{
    
    private TextView                  saveAll;
    
    private View                      viewPhotoAlbum;
    
    private View                      viewForm;
    
    private Button                    buttonTabPhotoAlbumView;
    
    private Button                    buttonTabFormView;
    
    private TextView                  textViewTakingPhoto;
    
    private EditingAlbumManager       editingAlbumManager;
    
    private EditingRegisterXMLManager editingRegisterXMLManager;
    
    /* --- forms --- */

    private EditText                  editTextIdAmostra;
    
    private EditText                  editTextData;
    
    private EditText                  editTextHora;
    
    private HiddenFlipper             viewFlipper;
    
    private ListView                  availableRegisters;
    
    private GenericAdapter            adapter;
    
    private TextView                  onEditRegisterName;
    
    private String                    onEditRegisterPath;
    
    public void onCreate ( Bundle savedInstanceState )
    {
        
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_maintain_register );
        
        ViewFlipper vf = ( (ViewFlipper) findViewById ( R.id.viewFlipper1 ) );
        
        this.viewFlipper = new HiddenFlipper ( vf );
        
        this.availableRegisters = (ListView) findViewById ( R.id.listView1 );
        
        this.adapter = new GenericAdapter ( this , this.generateRegisterItemArray ( ) );
        
        this.availableRegisters.setAdapter ( this.adapter );
        
        /*---------------------------------------------------
         * 
         *                  Taking care of stubs
         *
         *--------------------------------------------------*/

        this.echo ( "Recovering EditScreen View" );
        
        View viewEditScreenViewer = ( (ViewStub) vf.getChildAt ( 1 ) ).inflate ( );
        
        /* --- views for edition --- */

        this.echo ( "Build Stance for Photo Album View" );
        
        this.viewPhotoAlbum = ( (ViewStub) viewEditScreenViewer.findViewById ( R.id.viewStub_maintainregister_photo_album ) ).inflate ( );
        
        this.echo ( "Build Stance for Form View" );
        
        this.viewForm = ( (ViewStub) viewEditScreenViewer.findViewById ( R.id.viewStub_maintainregister_form ) ).inflate ( );
        
        /* --- EditViewer Elements --- */

        this.echo ( "Recovering elements from EditViewer" );
        
        this.echo ( "Build Stance for Button Invoker Form" );
        
        this.buttonTabFormView = (Button) viewEditScreenViewer.findViewById ( R.id.button_maintainregister_invoke_forms );
        
        this.echo ( "Build Stance for Button Invoker Album" );
        
        this.buttonTabPhotoAlbumView = (Button) viewEditScreenViewer.findViewById ( R.id.button_maintainregister_invoke_photo_album );
        
        this.echo ( "Build Stance for Button Save All" );
        
        this.saveAll = (TextView) viewEditScreenViewer.findViewById ( R.id.textView_maintainregister_save_all );
        
        this.onEditRegisterName = (TextView) viewEditScreenViewer.findViewById ( R.id.textView_edit_screen_register_name );
        
        /* --- photo album --- */

        this.echo ( "Recovering elements from PhotoAlbum" );
        
        this.echo ( "Build Stance for Button TakingPhoto" );
        
        this.textViewTakingPhoto = (TextView) this.viewPhotoAlbum.findViewById ( R.id.textView_edit_photo_album_take_pic );
        
        this.echo ( "Build Stance for GridView Photo Gallery" );
        
        GridView gridViewEditPhotoAlbum = (GridView) this.viewPhotoAlbum.findViewById ( R.id.gridView_edit_photo_album_gallery );
        
        /* --- forms --- */

        this.echo ( "Recovering elements from Forms" );
        
        this.echo ( "Build Stance for EditText ID" );
        
        this.editTextIdAmostra = (EditText) this.viewForm.findViewById ( R.id.editText_register_form_ID_AMOSTRA );
        
        this.echo ( "Build Stance for EditText Date" );
        
        this.editTextData = (EditText) this.viewForm.findViewById ( R.id.editText_register_form_DATE );
        
        this.echo ( "Build Stance for EditText Hour" );
        
        this.editTextHora = (EditText) this.viewForm.findViewById ( R.id.editText_register_form_HOUR );
        
        if ( this.editTextData == null )
        {
            this.emptyView ( );
        }
        
        /*----------------------------------------------------
         * 
         *           Setting Up Photo Album
         * 
         *---------------------------------------------------*/
        
        this.editingAlbumManager = new EditingAlbumManager ( this , gridViewEditPhotoAlbum , 2 );
        
        this.editingRegisterXMLManager = new EditingRegisterXMLManager ( );
        
        /*---------------------------------------------------
         * 
         *                 OnSelect Register
         *  
         *---------------------------------------------------*/

        this.echo ( "Setup OnItemClickEvent for our ListView1" );
        
        this.availableRegisters.setOnItemClickListener (

        new OnItemClickListener ( )
                {
                    
                    public void onItemClick ( AdapterView < ? > arg0 , View arg1 , int arg2 , long arg3 )
                    {
                        // TODO Auto-generated method stub
                        selectingRegister ( arg0 , arg1 , arg2 , arg3 );
                    }
                }
         );
        
        /*-----------------------------------------------------
         * 
         *                   Build Tab
         * 
         *----------------------------------------------------*/

        /*-----------------------------------------------------
         *                   
         *                   Button Tabs
         *                   
         *-----------------------------------------------------*/

        this.echo ( "Setup OnClickEvent for tabButtons" );
        
        buttonTabPhotoAlbumView.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                switchFromFormToPhotoAlbum ( );
            }
        } );
        
        buttonTabFormView.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                switchFromPhotoAlbumToForm ( );
            }
        } );
        
    }
    
    private void emptyView ( )
    {
        // TODO Auto-generated method stub
        Toast.makeText ( this , "Null Stuff" , Toast.LENGTH_SHORT ).show ( );
    }
    
    private SdcardManager sdcardManager = new SdcardManager ( );
    
    private ArrayList < GenericItemList > generateRegisterItemArray ( )
    {
        ArrayList < GenericItemList > items = new ArrayList < GenericItemList > ( );
        
        ArrayList < String > foldersName = this.sdcardManager.toArrayListFolders ( "SINBIO" );
        
        for ( String name : foldersName )
        {
            items.add ( new RegisterItem ( R.layout.pojo_register_item , name , this.sdcardManager.getBasePath ( ) + "/" + "SINBIO" + "/" + name ) );
        }
        
        return items;
    }
    
    /*
     * 
     * ULtimo metodo a ser chamado quando a seleção é feita :D
     */

    RegisterItem i ;
    
    public void selectingRegister ( AdapterView < ? > arg0 , View arg1 , int arg2 , long arg3 )
    {
        Toast.makeText ( this , "Selecting " + arg2 + " item" , Toast.LENGTH_SHORT ).show ( );
        
        try
        {
            
            RegisterItem i = (RegisterItem) arg0.getItemAtPosition ( arg2 );
            
            this.i = i;
            
            Toast.makeText ( this , "Register Name [" + i.getRegisterName ( ) + "]" , Toast.LENGTH_SHORT ).show ( );
            
            if( i == null )
            {
                this.emptyView ( );
            }
            
            this.onEditRegisterPath = i.getRegisterPath ( );
            
            this.onEditRegisterName.setText ( i.getRegisterName ( ) );
            
            
         
            this.fillTheFields (  );
            
            this.viewFlipper.turnToRight ( );
            
            this.switchFromFormToPhotoAlbum ( );// para que o layout chegue coloridinho :3
            
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            Toast.makeText ( this , "BusyBox on the head @_@" , Toast.LENGTH_SHORT ).show ( );
        }
    }
    
    /*
     * 
     * Filling all the field on forms
     */
    Element registerOnEdit;
    public void fillTheFields (  )
    {
        
        RegisterItem reg = this.i;
        
        this.echo(" loading photos from " + reg.getRegisterPath ( ));
        
//        this.editingAlbumManager.showAllAvailablePhotosAtPath (reg.getRegisterPath ( ) );
        
        this.editingAlbumManager.addPhotoVector ( this.sdcardManager.getPictures ( reg.getRegisterPath ( ) ) );
        
        
 
        
        
        
        String fileName = reg.getRegisterName ( ).toLowerCase ( ) ;
        
        String absolutePath = reg.getRegisterPath ( );
        
        this.echo ( "Try : loading dreg \nfile name  ["+fileName+"]\n file path ["+absolutePath+"]" );
        
        String dreg = this.editingRegisterXMLManager.getDreg ( fileName , absolutePath );
        
        this.echo ( "Dreg files was loaded \n"+dreg );
        
        if( dreg == null )
        {
            this.echo ( "Shit nigga! cant find file :D" );
        }
        
        
        RegisterXml savedReg = new RegisterXml ( dreg );
//       
       
        this.echo ( " Setting values for forms " );
        
        this.editTextIdAmostra.setText ( (CharSequence) savedReg.getIdAmostra ( ) );
        
        this.editTextData.setText ( (CharSequence)  savedReg.getData ( ) );
        
        this.editTextHora.setText ((CharSequence)  savedReg.getHora ( ) );
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_maintain_register , menu );
        return true;
    }
    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , "CreateReg : " + msg );
    }
    
  
    
    public void switchFromPhotoAlbumToForm ( )
    {
        this.viewPhotoAlbum.setVisibility ( View.GONE );
        this.viewForm.setVisibility ( View.VISIBLE );
        
        Resources r = getResources ( );
        
        this.buttonTabFormView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_144d3c_borders_no_rounded ) );
        this.buttonTabFormView.setTextColor ( Color.WHITE );
        
        this.buttonTabPhotoAlbumView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_ffffff_borders_no_rounded ) );
        this.buttonTabPhotoAlbumView.setTextColor ( Color.BLACK );
        
    }
    
    public void switchFromFormToPhotoAlbum ( )
    {
        this.viewForm.setVisibility ( View.GONE );
        this.viewPhotoAlbum.setVisibility ( View.VISIBLE );
        
        Resources r = getResources ( );
        
        this.buttonTabPhotoAlbumView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_144d3c_borders_no_rounded ) );
        this.buttonTabPhotoAlbumView.setTextColor ( Color.WHITE );
        
        this.buttonTabFormView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_ffffff_borders_no_rounded ) );
        this.buttonTabFormView.setTextColor ( Color.BLACK );
    }
    
    /*--------------------------------------------------
     * 
     *                      POJO
     *
     *--------------------------------------------------*/

    private class RegisterItem extends GenericItemList
    {
        
        private long   id;
        
        private int    layout;
        
        private String registerName;
        
        private String registerPath;
        
        public RegisterItem ( int layout , String registerName , String registerPath )
        {
            super ( );
            this.layout = layout;
            this.registerName = registerName;
            this.registerPath = registerPath;
        }
        
        @ SuppressWarnings ( "unused" )
        public String getRegisterName ( )
        {
            return registerName;
        }
        
        @ SuppressWarnings ( "unused" )
        public void setRegisterName ( String registerName )
        {
            this.registerName = registerName;
        }
        
        public String getRegisterPath ( )
        {
            return registerPath;
        }
        
        @ SuppressWarnings ( "unused" )
        public void setRegisterPath ( String registerPath )
        {
            this.registerPath = registerPath;
        }
        
        @ Override
        public View initializeWidgets ( View v )
        {
            // TODO Auto-generated method stub
            
            ( (TextView) v.findViewById ( R.id.textView_pojo_register_item_name ) ).setText ( this.registerName );
            return v;
        }
        
        @ Override
        public int getLayout ( )
        {
            // TODO Auto-generated method stub
            return this.layout;
        }
        
        @ Override
        public void setLayout ( int layout_id )
        {
            // TODO Auto-generated method stub
            this.layout = layout_id;
        }
        
        @ Override
        public long getId ( )
        {
            // TODO Auto-generated method stub
            return this.id;
        }
        
        @ Override
        public void setId ( long id )
        {
            // TODO Auto-generated method stub
            this.id = id;
        }
        
    }
}
