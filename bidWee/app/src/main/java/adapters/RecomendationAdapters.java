package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bidwee.activities.R;

import java.util.List;

import models.RecommendationModel;

/**
 * Created by Suneet on 07-Oct-15.
 */
public class RecomendationAdapters extends BaseAdapter {

    private List<RecommendationModel> recomendationList;
    private Context _context;

    public RecomendationAdapters(Context _context, List<RecommendationModel> hishScoreList) {
        super();
        this.recomendationList = hishScoreList;
        this._context = _context;
    }

    @Override
    public int getCount() {
        return recomendationList.size();
    }

    @Override
    public Object getItem(int position) {
        return recomendationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recomendationList.get(position).hashCode();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflator = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(R.layout.recommendation_listitem, null);
        }

        TextView mrpTextview = (TextView) view.findViewById(R.id.item_mrpTextview);
        TextView bestpriceTextview = (TextView) view.findViewById(R.id.item_bestPriceTextview);

        mrpTextview.setText(recomendationList.get(position).getMrp());
        bestpriceTextview.setText((recomendationList.get(position).getBestPriceAvailable()));

        return view;
    }
}
