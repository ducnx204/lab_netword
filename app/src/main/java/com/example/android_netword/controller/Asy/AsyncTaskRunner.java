package com.example.android_netword.controller.Asy;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_netword.view.BaiTap.Lab1Bai4Activity;

public class AsyncTaskRunner extends AsyncTask<String,String,String> {

    private String resp;
    ProgressDialog dialog;
    TextView tvResult;
    EditText edt_ASYTASK;
    Context context;
    
    public AsyncTaskRunner( Context context, TextView tvResult, EditText edt_ASYTASK) {
        this.tvResult = tvResult;
        this.edt_ASYTASK = edt_ASYTASK;
        this.context = context;
    }



    protected void onPreExecute(){
        super.onPreExecute();
        dialog = ProgressDialog.show(context,"ProgressDialog","Wait for" + edt_ASYTASK.getText().toString()+"seconds");
    }
    @Override
    protected String doInBackground(String...  params) {
        publishProgress("Sleeping...");
        try {
            int edt_ASYTASK = Integer.parseInt(params[0])*1000;
            Thread.sleep(edt_ASYTASK);
            resp = "Slept for" + params[0] + "seconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        if (dialog.isShowing()){
            dialog.dismiss();
        }
        tvResult.setText(result);
    }
}
