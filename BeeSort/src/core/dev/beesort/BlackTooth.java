package core.dev.beesort;

import java.util.Set;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BlackTooth {

	BluetoothAdapter bluetoothAdapter;

	Context context;

	public BlackTooth(Context context) {
		
		this.context = context;

		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		
		
		if (bluetoothAdapter == null) {
			// Device does not support Bluetooth

			Toast.makeText(this.context,
					(CharSequence) "Compra um celular melhor né?",
					Toast.LENGTH_SHORT).show();

		}
	
		else {

			int REQUEST_ENABLE_BT = 1;

			if (!this.bluetoothAdapter.isEnabled()) {
				Intent enableBtIntent = new Intent(
						BluetoothAdapter.ACTION_REQUEST_ENABLE);
			( (Activity) (this.context) ).startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			}
		}
	}

	ProgressDialog dialog;

	private void showLoadingDevicesPopUp() {
		this.dialog = new ProgressDialog(this.context);

		this.dialog.show(this.context, "BeeSort", "Loading device list. Please wait...", true);
	}

	private void closeLoadingDevicesPopUp() {
		this.dialog.dismiss();
	}

	public CharSequence toStringListPairedDevices() {
		String s = "";

		Set<BluetoothDevice> pairedDevices;

		try {

			pairedDevices = this.bluetoothAdapter.getBondedDevices();

			this.showLoadingDevicesPopUp();

			// If there are paired devices
			if (pairedDevices.size() > 0) {
				// Loop through paired devices
				for (BluetoothDevice device : pairedDevices) {
					// Add the name and address to an array adapter to show in a
					// ListView
					s += device.getName() + "\n" + device.getAddress() + "\n";
				}
			}

		} catch (NullPointerException e) {
			// TODO: handle exception

			Toast.makeText(this.context,
					(CharSequence) "Compra um celular melhor né?",
					Toast.LENGTH_SHORT).show();

		}

		this.closeLoadingDevicesPopUp();

		return s;
	}

}
