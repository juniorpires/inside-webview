package tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


/**
 * Classe que tem métodos úteis 
 * para a aplicação
 * @author albuquerque
 *
 */
public class AndroidUtils {
	
	protected static final String TAg="inside";
	
	public static boolean isNetworkAvailable(Context context){
		ConnectivityManager connectivity=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (connectivity == null){
			return false;
		}
		else{
			NetworkInfo[] info=connectivity.getAllNetworkInfo();
			if (info != null){
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void alertDialog(final Context context, final int mensagem){
		try{
			AlertDialog dialog= new AlertDialog.Builder(context)
					.setTitle("Rede Next")
					.setMessage(mensagem)
					.create();

			dialog.setButton("OK", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					return;
				}

			});

			dialog.show();
		}catch(Exception e){
			Log.e(TAg, e.getMessage(), e);
		}
	}

	public static AlertDialog alertDialog(final Context context, final String mensagem){
		try{
			AlertDialog dialog= new AlertDialog.Builder(context)
					.setTitle("Rede Next")
					.setMessage(mensagem)
					.create();

			dialog.setButton("OK", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					return;
				}

			});

			dialog.show();
			return dialog;
		}catch(Exception e){
			Log.e(TAg, e.getMessage(), e);
			return null;
		}
	}

}
