package core.dev.gridview;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GenericAdapter extends BaseAdapter {

	ArrayList<GenericItemList> items;

	Context context;

	/* --- mah methods --- */
	
	public void addItem(GenericItemList item)
	{
		this.items.add(item);
		
	}
	
	public void removeItemByIndex( int position )
	{
		this.items.remove(position);
	}
	
	public void removeItemById( long id )
	{
		for( GenericItemList item : this.items )
		{
			if( item.getId() == id )
			{
				this.items.remove( this.items.indexOf(item) );
				
				break;
			}
		}
	}
	

	public GenericAdapter(Context context, ArrayList<GenericItemList> items) {
		super();
		this.items = items;
		this.context = context;

	}
	
	
	public GenericAdapter(Context context) {
		super();
		this.context = context;
		
		
		
		this.items = new ArrayList<GenericItemList>();

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return this.items.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.items.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return this.items.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		/* 2 - Essa primeira parte aqui consegue identificar o layout (arquivo xml)
		 * que contem o modelo dos items que queres carregar em determinada estrutura,
		 * seja ela gridview, listview, etc...
		 * 
		 * essa arquitetura � mais f�cil pois o xml veio para dividir, e dividir muito bem, o que
		 * � perfumaria e o que programa��o. Ao contr�rio do que muitos ignorantes do BCC e BSI
		 * o java, assim como C, C++ e outra linguagens tradicionais, constroem GUI baseadas em arquivos XML
		 * 
		 * Esse estilo de constru��o separar como o widget deve ser emebelezado da parte de como ele vai se 
		 * comportar ou ser desenhado na tela. Toda vez que usamos ferramentas RAID para construir GUI
		 * 
		 * normalmente ele deve produzir um .xml ou no caso do swing um .ui (que nada mais � um xml) para que o seu
		 * programa carregue ele sem maiores preocupa��es! Isso ajuda na quest�o, n�o menos importante, dos designers
		 * seu jogo 3D usar arquivos xml para abstrair o queo hard faz no 3Dmax, isso possibilita n�o saberes PN de Nada
		 * de modelagem 3D e mesmo assim programar colis�es, e outras a��es.
		 * 
		 * Portanto todas que precisas por algo em uma lista, nem que seja um textview, fa�a o .xml dele
		 * 
		 * 
		 */
		
		/* 2.1 - como disse aqui est� o layout/xml que define como ser� o item
		 */
		
		int layout = this.items.get(position).getLayout();
		
		/*
		 * 2.2 - aqui estou apenas setando o ID dele. Esse ID, vai servir para identificar ele na lista.
		 * possibilitando a��es como a de remo��o.
		 * no caso n�o estou trabalhando com gridview ainda. esse ai est� sendo armazenado na classe que criei
		 * para abstrai o meu xml que define meu item.
		 * 
		 */
		
		this.items.get(position).setId(position);
		
		/*
		 * 2.3 -  aqui ele est� pegando esse convertView e setando para um variavel temporaria.
		 * Chamei a mesmo de rowView porque na primeira vez que fiz isso era pra ser uma lista.
		 * 
		 * Logo a ideia a ser passa era que essa inst�ncia de uma view (converView) representa a view
		 * que ser� apresentada nas linhas da ListView. Mas no fim das contas essa instancia � em si 
		 * aonde seu item na posi��o X vai ser referenciado
		 * 
		 */
		
		View rowView = convertView;
		
		/*
		 * 2.4 - aqui ele vai verificar se a view est� nula pois, se isso for verdade significa que esse
		 * objeto que deveria esta na posi��o X qualquer n�o est� ainda "carregado".
		 * Logo se for falso significa que ja temos um item pronto e carregado, basta ent�o fazer o passo final.
		 */
		
		if (rowView == null) {
			
			/* 2.4.1 - Se essa view/item n�o for uma instancia valida devemos ent�o fazer ela apontar/referenciar
			 * para um Modelo/Layout que sirva para abstrair os items que queremos.
			 * 
			 * Para isso precisamos desse metodo em particular (.inflate). Se pesquisares um pouco vais descobrir
			 * que essa � uma tecnica bem antiga de programa��o.
			 * 
			 * O lance aqui � o seguinte. Como disse antes pra usarmos um xml como base pra definir como vai ser a estrutura
			 * dos nossos items � obvio que o android n�o sabe que tipo de Views especificas usamos para construir ele.
			 * Ent�o deve inflar esse "Bal�o"/espa�o_em_memoria para que ele tome a forma que definimos no XML
			 * 
			 * A View � a classe mais generica para referenciarmos qualquer tipo de elemento grafico, logo ela � um bat�o com poder
			 * de inflar de varias formas. o inflater vai modelar qual forma precisamos
			 * 
			 */
			
			rowView = (LayoutInflater.from(context)).inflate(layout, null);

			/*
			 * 2.4.2 - podemos ver uma express�o simples :D
			 * � para que nosso rowView tenha o mesmo ID que setamos no nosso POJO/Objeto que criamos para representar
			 * nossos items :D
			 */
			
			rowView.setId(position);
			
			
		}

		/*
		 * 2.5 - Caso o if falhe, significa que estamos lidando com uma instancia de um item que j� foi inflado
		 * ou seja, ele ja tem a "forma" ideal que queremos.
		 * Logo podemos pintar e bordar com nossas views especificas (buttons, textviews, etc) 
		 */
		
		/*
		 * 2.6 - OMG cade nosso codigo de configura��o! Nem sempre o cara que assopra os bal�es sabe como 
		 * amarrar eles, e pior, n�o sabe com o usar ele na decora��o.
		 * Esse aqui � �s de espadas. Esse bostinha aqui � que faz meu Adapter ser adaptativo para todos.
		 * 
		 * poderia muito bem chegar aqui, nesse exemplo, e pegar o bot�o do layout que definimos.
		 * 
		 * Button b = ( Button )rowView.findViewById( ... )
		 * 
		 * Mas e se eu quisesse usar um bot�o e mais um TextView no meu xml que define o item? logo teriamos
		 * 
		 * Button b = ( Button )rowView.findViewById( ... )
		 * 
		 * TextView tv = (TextView) rowView.findViewById( ... )
		 * 
		 * Ent�o pensa comigo a unica coisa que muda � a quantidade de instru��es ok? Mas todas elas come�am
		 * obrigatoriamente com essa "puxada" dessas Views que compoe meus items da instancia valida que sera encaixada
		 * na minha esturura maior.
		 * 
		 *  Como disse antes o assopra n�o � tamb�m decorador. Assim o Adapter sabe como encaixar os items, mas n�o necessariamente
		 *  como pinta-los, logo quem tem que saber fazer isso � outra classe por fora.
		 *  
		 *  foi o que eu fiz. como fiz o POJO para representar os elementos que compoem nossa view que representa nosso item
		 *  bastou criar um espa�o para dizer como configurar a view.
		 *  
		 *  se tu tirares o que esta escrito no metodo initializeWidget() e por ele aqui embaixo, vai funcionar do mesmo jeito
		 *  por�m se precisares de um listview, ou spinner, vais ter que cometer o ato ignorante de criar outro "assoprador"
		 *  especifico :D
		 * 
		 */
		
		rowView = this.items.get(position).initializeWidgets(rowView);

		return rowView;

	}

}
