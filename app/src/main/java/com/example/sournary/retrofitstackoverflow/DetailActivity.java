package com.example.sournary.retrofitstackoverflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sournary.retrofitstackoverflow.model.Item;
import com.example.sournary.retrofitstackoverflow.view.StackexchangeAdapter;

public class DetailActivity extends AppCompatActivity {

    private TextView mReputationTv, mUserIdTv, mUserType, mAcceptRateTv, mProfileImageTv, mDisplayNameTv, mLinkOwnerTv;
    private TextView mIsAnswerTv, mLastActivityDateTv, mCreationDateTv, mQuestionIdTv, mLastEditDate;

    private void findViewByIds() {
        mReputationTv = (TextView) findViewById(R.id.tv_repulation);
        mUserIdTv = (TextView) findViewById(R.id.tv_user_id);
        mUserType = (TextView) findViewById(R.id.tv_user_type);
        mAcceptRateTv = (TextView) findViewById(R.id.tv_accepte_rate);
        mProfileImageTv = (TextView) findViewById(R.id.tv_profile_image);
        mDisplayNameTv = (TextView) findViewById(R.id.tv_display_name);
        mLinkOwnerTv = (TextView) findViewById(R.id.tv_link_owner);

        mIsAnswerTv = (TextView) findViewById(R.id.tv_is_answered);
        mLastActivityDateTv = (TextView) findViewById(R.id.tv_last_activity_date);
        mCreationDateTv = (TextView) findViewById(R.id.tv_creation_date);
        mQuestionIdTv = (TextView) findViewById(R.id.tv_question_id);
        mLastEditDate = (TextView) findViewById(R.id.tv_last_edit_date);
    }

    private void setEvents() {
        Intent intent = getIntent();
        Item item = (Item) intent.getSerializableExtra(StackexchangeAdapter.ITEM_EXTRA);
        mReputationTv.setText(item.getOwner().getReputation() + "");
        mUserIdTv.setText(item.getOwner().getUserId() + "");
        mUserType.setText(item.getOwner().getUserType());
        mAcceptRateTv.setText(item.getOwner().getAcceptRate() + "");
        mProfileImageTv.setText(item.getOwner().getProfileImage());
        mDisplayNameTv.setText(item.getOwner().getDisplayName());
        mLinkOwnerTv.setText(item.getOwner().getLink());

        mIsAnswerTv.setText(item.getAnswerId() + "");
        mLastActivityDateTv.setText(item.getLastActivityDate() + "");
        mCreationDateTv.setText(item.getCreationDate() + "");
        mQuestionIdTv.setText(item.getQuestionId() + "");
        mLastEditDate.setText(item.getLastEditDate() + "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViewByIds();
        setEvents();
    }

}
