package com.frankgreen.task;

import android.os.AsyncTask;

import com.frankgreen.NFCReader;
import com.frankgreen.apdu.Result;
import com.frankgreen.apdu.command.GetVersion;
import com.frankgreen.apdu.command.ReadBinaryBlock;
import com.frankgreen.apdu.command.Reset;
import com.frankgreen.apdu.command.UID;
import com.frankgreen.params.BaseParams;
import com.frankgreen.params.ReadParams;


/**
 * Created by kevin on 6/2/15.
 */
public class SoftResetTask extends AsyncTask<BaseParams, Void, Boolean> {

    final private String TAG = "SoftResetTask";

    @Override
    protected Boolean doInBackground(BaseParams... paramses) {
        final BaseParams params = paramses[0];
        if (params == null) {
            return false;
        }
        if (!params.getReader().isReady()) {
            params.getReader().raiseNotReady(params.getOnGetResultListener());
            return false;
        }
        final Reset reset = new Reset(params);
        reset.setSendPlugin(false);
        

        final TaskListener resetListener = new TaskListener() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onFailure() {

            }

            @Override
            public void onException() {

            }
        };
        reset.run(resetListener);
        return true;
    }

}


