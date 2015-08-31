package com.example.fragmentdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;
    //private SettingFragment settingFragment;

    private View messageLayout;
    private View contactsLayout;
    private View newsLayout;
    //private View settingLayout;

    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;
    //private ImageView settingImage;

    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;
    //private TextView settingText;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();
        fragmentManager=getFragmentManager();
        setTabSelection(0);
    }

    private  void initViews(){
        messageLayout = findViewById(R.id.message_layout);
        contactsLayout = findViewById(R.id.contacts_layout);
        newsLayout = findViewById(R.id.news_layout);
        //settingLayout = findViewById(R.id.setting_layout);
        messageImage = (ImageView) findViewById(R.id.message_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        newsImage = (ImageView) findViewById(R.id.news_image);
        //settingImage = (ImageView) findViewById(R.id.setting_image);
        messageText = (TextView) findViewById(R.id.message_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        //settingText = (TextView) findViewById(R.id.setting_text);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        //settingLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.message_layout:
                // ���������Ϣtabʱ��ѡ�е�1��tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // ���������ϵ��tabʱ��ѡ�е�2��tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // ������˶�̬tabʱ��ѡ�е�3��tab
                setTabSelection(2);
                break;
            /*case R.id.setting_layout:
                // �����������tabʱ��ѡ�е�4��tab
                setTabSelection(3);
                break;*/
            default:
                break;
        }
    }

    /**
     * ���ݴ����index����������ѡ�е�tabҳ��
     *
     * @param index
     *            ÿ��tabҳ��Ӧ���±ꡣ0��ʾ��Ϣ��1��ʾ��ϵ�ˣ�2��ʾ��̬��3��ʾ���á�
     */
    private void setTabSelection(int index) {
        // ÿ��ѡ��֮ǰ��������ϴε�ѡ��״̬
        clearSelection();
        // ����һ��Fragment����
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // �����ص����е�Fragment���Է�ֹ�ж��Fragment��ʾ�ڽ����ϵ����
        hideFragments(transaction);
        switch (index) {
            case 0:
                // ���������Ϣtabʱ���ı�ؼ���ͼƬ��������ɫ
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if (messageFragment == null) {
                    // ���MessageFragmentΪ�գ��򴴽�һ������ӵ�������
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // ���MessageFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                // ���������ϵ��tabʱ���ı�ؼ���ͼƬ��������ɫ
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if (contactsFragment == null) {
                    // ���ContactsFragmentΪ�գ��򴴽�һ������ӵ�������
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {
                    // ���ContactsFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                // ������˶�̬tabʱ���ı�ؼ���ͼƬ��������ɫ
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment == null) {
                    // ���NewsFragmentΪ�գ��򴴽�һ������ӵ�������
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    // ���NewsFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
                    transaction.show(newsFragment);
                }
                break;
            /*case 3:
            default:
                // �����������tabʱ���ı�ؼ���ͼƬ��������ɫ
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if (settingFragment == null) {
                    // ���SettingFragmentΪ�գ��򴴽�һ������ӵ�������
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    // ���SettingFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
                    transaction.show(settingFragment);
                }
                break;*/
        }
        transaction.commit();
    }

    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        /*settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));*/
    }

    /**
     * �����е�Fragment����Ϊ����״̬��
     *
     * @param transaction
     *            ���ڶ�Fragmentִ�в���������
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        /*if (settingFragment != null) {
            transaction.hide(settingFragment);
        }*/
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
