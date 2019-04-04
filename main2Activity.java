
        public class Main2Activity extends AppCompatActivity {



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);

                Calendar calendar = Calendar.getInstance();
                calendar.set(

                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        12,
                        17,
                        0


                );



                setAlart(calendar.getTimeInMillis());
            }

            private void setAlart(long timeInMillis) {


                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent = new Intent(Main2Activity.this,MyReminder.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(Main2Activity.this,0,intent,0);
               alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);



            }
        }
