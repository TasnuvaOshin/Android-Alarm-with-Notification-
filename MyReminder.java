

                public class MyReminder extends BroadcastReceiver {

                    private NotificationManager notifManager;


                    @Override
                    public void onReceive(Context context, Intent intent) {

                      MediaPlayer mediaPlayer = MediaPlayer.create(context,Settings.System.DEFAULT_RINGTONE_URI);
                        mediaPlayer.start();
                      mediaPlayer.setLooping(true);
                        createNotification("Your Message is Here",context);

                    }

                    public void createNotification(String aMessage, Context context) {
                        final int NOTIFY_ID = 0; // ID of notification
                        String id = "one"; // default_channel_id
                        String title = "Match Update"; // Default Channel
                        Intent intent;
                        PendingIntent pendingIntent;
                        NotificationCompat.Builder builder;
                        if (notifManager == null) {
                            notifManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            int importance = NotificationManager.IMPORTANCE_HIGH;
                            NotificationChannel mChannel = notifManager.getNotificationChannel(id);
                            if (mChannel == null) {
                                mChannel = new NotificationChannel(id, title, importance);
                                mChannel.enableVibration(true);
                                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                                notifManager.createNotificationChannel(mChannel);
                            }
                            builder = new NotificationCompat.Builder(context, id);
                            intent = new Intent(context, Main2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                            builder.setContentTitle(aMessage)                            // required message
                                    .setSmallIcon(android.R.drawable.ic_popup_reminder)   // required
                                    .setContentText(context.getString(R.string.app_name)) // required this is mainly title
                                    .setDefaults(Notification.DEFAULT_ALL)
                                    .setAutoCancel(true)
                                    .setContentIntent(pendingIntent)
                                    .setTicker(aMessage)
                                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                        }
                        else {
                            builder = new NotificationCompat.Builder(context, id);
                            intent = new Intent(context, Main2Activity.class); //which clas it should go
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
                            builder.setContentTitle(aMessage)                            // required
                                    .setSmallIcon(android.R.drawable.ic_popup_reminder)   // required
                                    .setContentText(context.getString(R.string.app_name)) // required
                                    .setDefaults(Notification.DEFAULT_ALL)
                                    .setAutoCancel(true)
                                    .setContentIntent(pendingIntent)
                                    .setTicker(aMessage)
                                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                                    .setPriority(Notification.PRIORITY_HIGH);
                        }
                        Notification notification = builder.build();
                        notifManager.notify(NOTIFY_ID, notification);
                    }


                }
