package graycap.echo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import graycap.echo.Fragment.AboutUs
import graycap.echo.Fragment.Favorite
import graycap.echo.Fragment.MainScreenFragment
import graycap.echo.Fragment.Setting
import graycap.echo.R
import graycap.echo.activities.MainActivity

class NavigationDrawerAdapter(_contentList: ArrayList<String>, _getImages: IntArray, _context: Context)
    : RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>() {

    var contentList: ArrayList<String>? = null
    var getImages: IntArray? = null
    var mContext: Context? = null

    init {
        this.contentList = _contentList
        this.getImages = _getImages
        this.mContext = _context
    }
    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {

        holder?.icon_Get?.setBackgroundResource(getImages?.get(position) as Int)
        holder?.text_Get?.setText(contentList?.get(position))
        holder?.contentHolder?.setOnClickListener({

            if (position == 0) {
                val mainScreenFragment = MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, mainScreenFragment)
                        .commit()
            } else if (position == 1) {
                val favoriteFragment = Favorite()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, favoriteFragment)
                        .commit()
            } else if (position == 2) {
                val settingFragment = Setting()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, settingFragment)
                        .commit()
            } else if (position == 3) {
                val aboutUsFragment = AboutUs()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragment, aboutUsFragment)
                        .commit()
            }
            MainActivity.Statified.drawerLayout?.closeDrawers()
        })

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {

        var itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_navigationdrawer, parent, false)
        val returnThis = NavViewHolder(itemView)
        return returnThis
    }


    override fun getItemCount(): Int {
        return (contentList as ArrayList).size
    }


    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var icon_Get: ImageView? = null
        var text_Get: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            icon_Get = itemView?.findViewById(R.id.icon_navdrawer)
            text_Get = itemView?.findViewById(R.id.text_navdrawer)
            contentHolder = itemView?.findViewById(R.id.navdrawer_item_content_holder)

        }

    }
}