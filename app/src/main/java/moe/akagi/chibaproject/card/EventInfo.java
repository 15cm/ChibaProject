package moe.akagi.chibaproject.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import moe.akagi.chibaproject.R;
import moe.akagi.chibaproject.database.API;
import moe.akagi.chibaproject.database.Data;
import moe.akagi.chibaproject.datatype.Event;
import moe.akagi.chibaproject.datatype.Person;
import moe.akagi.chibaproject.datatype.Time;

/**
 * Created by yunze on 12/2/15.
 */
public class EventInfo extends Card {

    protected Context mContext;
    protected CardHeader header;
    protected Event event;

    protected ImageView infoImage;
    protected TextView timeText;
    protected TextView placeText;

    protected int timeViewId;
    protected int placeViewId;
    protected int imageViewId;


    public EventInfo(Context context, int innerLayout, Event event) {
        super(context, innerLayout);
        mContext = context;
        header = new CardHeader(mContext);
        this.addCardHeader(header);
        this.event = event;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        timeText = (TextView) parent.findViewById(this.timeViewId);
        placeText = (TextView) parent.findViewById(this.placeViewId);
        infoImage = (ImageView) parent.findViewById(this.imageViewId);
        Context context = parent.getContext();

        header.setTitle(getTitle());

        if (timeText != null)
            timeText.setText(getTime());

        if (placeText != null)
            placeText.setText(getPlace());


        if (infoImage != null) {
            int imageResId= context.getResources().getIdentifier(getImageId(), "drawable", context.getPackageName());
            infoImage.setImageResource(imageResId);
        }
    }

    public String getTitle() {
        return event.getTitle();
    }

    public String getTime() {
        Date date = new Date(event.getTime());
        Time time = new Time(date);
        String timeStr;
        if (time.getYear() == 1970) {
            timeStr = "日期时间待定";
        } else {
            if (event.isTimeStat()) {
                timeStr = time.formatDateAndTime();
            } else {
                timeStr = time.formatDate() + " 时间待定";
            }
        }
        return timeStr;
    }

    public String getPlace() {
        String place = event.getLocation();
        if (place == null || place.isEmpty()) {
            place = "地点待定";
        }
        return place;
    }

    public String getImageId() {
        Person manager = API.getPersonByPersonId(event.getManegerId());
        String resString = "profile_image_" + manager.getPhone();
        return resString;
    }



}
