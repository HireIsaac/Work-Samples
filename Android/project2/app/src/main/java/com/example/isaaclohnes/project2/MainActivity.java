package com.example.isaaclohnes.project2;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;
    private CoordinatorLayout mCLayout;
    private Button mButtonDo;
    private TextView mTextView;
    private ProgressBar mProgressBar;
    private AsyncTask mMyTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mActivity = MainActivity.this;
        mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mButtonDo = (Button) findViewById(R.id.btn_do);
        mTextView = (TextView) findViewById(R.id.tv);
        mProgressBar = (ProgressBar) findViewById(R.id.pb);
        mButtonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("");
                mMyTask = new DownloadTask()
                        .execute(
                                "Task 1",
                                "Task 2",
                                "Task 3",
                                "Task 4",
                                "Task 5",
                                "Task 6",
                                "Task 7",
                                "Task 8",
                                "Task 9",
                                "Task 10",
                                "Task 11",
                                "Task 12",
                                "Task 13",
                                "Task 14",
                                "Task 15",
                                "Task 16",
                                "Task 17",
                                "Task 18",
                                "Task 19",
                                "Task 20",
                                "Task 21",
                                "Task 22",
                                "Task 23",
                                "Task 24",
                                "Task 25",
                                "Task 26",
                                "Task 27",
                                "Task 28",
                                "Task 29",
                                "Task 30",
                                "Task 31",
                                "Task 32",
                                "Task 33",
                                "Task 34",
                                "Task 35",
                                "Task 36",
                                "Task 37",
                                "Task 38",
                                "Task 39",
                                "Task 40",
                                "Task 41",
                                "Task 42",
                                "Task 43",
                                "Task 44",
                                "Task 45",
                                "Task 46",
                                "Task 47",
                                "Task 48",
                                "Task 49",
                                "Task 50",
                                "Task 51",
                                "Task 52",
                                "Task 53",
                                "Task 54",
                                "Task 55",
                                "Task 56",
                                "Task 57",
                                "Task 58",
                                "Task 59",
                                "Task 60",
                                "Task 61",
                                "Task 62",
                                "Task 63",
                                "Task 64",
                                "Task 65",
                                "Task 66",
                                "Task 67",
                                "Task 68",
                                "Task 69",
                                "Task 70",
                                "Task 71",
                                "Task 72",
                                "Task 73",
                                "Task 74",
                                "Task 75",
                                "Task 76",
                                "Task 77",
                                "Task 78",
                                "Task 79",
                                "Task 80",
                                "Task 81",
                                "Task 82",
                                "Task 83",
                                "Task 84",
                                "Task 85",
                                "Task 86",
                                "Task 87",
                                "Task 88",
                                "Task 89",
                                "Task 90",
                                "Task 91",
                                "Task 92",
                                "Task 93",
                                "Task 94",
                                "Task 95",
                                "Task 96",
                                "Task 97",
                                "Task 98",
                                "Task 99",
                                "Task 100"
                        );
            }
        });
    }

    private class DownloadTask extends AsyncTask<String,Integer,List<String>>{
        protected void onPreExecute(){
        }

        protected List<String> doInBackground(String...tasks){
            int count = tasks.length;
            List<String> taskList= new ArrayList<>(count);

            for(int i =0;i<count;i++){
                String currentTask = tasks[i];
                taskList.add(currentTask);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress((int) (((i+1) / (float) count) * 100));

                if(isCancelled()){
                    break;
                }
            }
            return taskList;
        }

        // After each task done
        protected void onProgressUpdate(Integer... progress){
            mTextView.setText(""+progress[0] + " %");
            mProgressBar.setProgress(progress[0]);
        }
        protected void onPostExecute(List<String> result) {
        }
    }
}