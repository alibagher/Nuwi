package com.example.Nuwi.Adapters

//import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.Nuwi.*
import com.example.Nuwi.fragments.ProgressExerciseFragment

//import android.support.v4.app.FragmentPagerAdapter
//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
import com.example.Nuwi.fragments.ProgressHomeFragment
import com.example.Nuwi.fragments.ProgressSleepFragment
import com.example.Nuwi.fragments.ProgressStressFragment


//ArrayAdapter<DataModel>(context, R.layout.progress_scores, dataSet as ArrayList<DataModel?>), View.OnClickListener
//BaseAdapter(),
class CustomAdapter(private val context: Context, fm: FragmentManager, private val dataSet: ArrayList<DataModel>) : BaseAdapter() , View.OnClickListener,
    ListAdapter {

//    var mContext: Context

    // View lookup cache
    private class ViewHolder {
        var txtName: TextView? = null
        var txtType: TextView? = null
        var txtVersion: TextView? = null
        var info: ImageView? = null
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        println("getPage title");
//        return tabTitles[position]
//    }


    override fun onClick(v: View) {
        val position = v.getTag() as Int
        val dataModel: DataModel? = dataSet[position]
//        val dataModel = `object` as DataModel
//        when (v.id) {
//            R.id.pager -> Snackbar.make(
//                v,
//                "Release date " + dataModel!!.getName(),
//                Snackbar.LENGTH_LONG
//            )
//                .setAction("No action", null).show()
//        }
//        Snackbar.make(
//                v,
//                "Release date " + dataModel!!.getName(),
//                Snackbar.LENGTH_LONG
//            )
        println("onclick: " + dataSet[position]!!.getName())
    }

    private var lastPosition = -1;
        override fun getCount(): Int {
//            TODO("Not yet implemented")
            return dataSet.size;
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                  //  val homeFragment: HomeFragment = HomeFragment()
                    return ProgressHomeFragment()
                }
                1 -> {
                    return ProgressExerciseFragment()
                }
                2 -> {
                   // val movieFragment = MovieFragment()
                    return ProgressSleepFragment()
                }
                3 -> {
                    return ProgressStressFragment()
                }
                else -> return ProgressHomeFragment()
            }
        }

        override fun getItemId(position: Int): Long {
//            TODO("Not yet implemented")
            return position.toLong();
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var vview = inflater.inflate(com.example.Nuwi.R.layout.fragment_home, container, false)
        // Get the data item for this position
        var newConvertView: View? = convertView
        val dataModel = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder // view lookup cache stored in tag
        val result: View?
        if (newConvertView == null) {
            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context);
            newConvertView = inflater.inflate(R.layout.progress_scores, parent, false);
            viewHolder.txtName = newConvertView!!.findViewById<TextView>(R.id.textView8);
//         item    viewHolder.txtType = newConvertView!!.findViewById(R.id.textView8)
//            viewHolder.txtVersion = newConvertView.findViewById(R.id.version_number)
//            viewHolder.info = newConvertView.findViewById(R.id.item_info) as ImageView
            result = newConvertView
            newConvertView.tag = viewHolder
        } else {
            println("else");
            viewHolder = newConvertView!!.tag as ViewHolder
            result = newConvertView
        }
//        val animation: Animation = AnimationUtils.loadAnimation(
//            mContext,
//            if (position > lastPosition) R.anim.up_from_bottom else R.anim.down_from_top
//        )
//        result.startAnimation(animation)
        lastPosition = position
        println("test: " + viewHolder.javaClass.kotlin.qualifiedName);
//        println("test1:"+dataModel!!.javaClass.kotlin.qualifiedName);
        viewHolder.txtName!!.text = dataSet[position].getName();
//        viewHolder.txtType!!.text = dataModel.getType()
//        viewHolder.txtVersion!!.text = dataModel.getVersion_number()
//        viewHolder.info!!.setOnClickListener(this);
//        viewHolder.info!!.setTag(position)
        // Return the completed view to render on screen
        return newConvertView
    }

//    init {
//        mContext = context
//    }
}
