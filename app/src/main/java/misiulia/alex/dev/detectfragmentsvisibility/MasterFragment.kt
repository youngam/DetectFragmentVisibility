package misiulia.alex.dev.detectfragmentsvisibility

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MasterFragment : AppFragment(), Subscriber {
    private lateinit var oldName: String
    private var newName: String? = null

    private lateinit var nameAdapter : NameAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.master_fragment_layout, container, false)
        initView(view)
        // to receive pseudo notifications
        NotificationManager.subscribe(this)
        return view
    }

    private fun initView(view: View) {
        val recyclerView = view.findViewById(R.id.names_recycler_view) as RecyclerView
        nameAdapter = NameAdapter({ name ->
            oldName = name
            (activity as MainActivity).navigate(from = this, to = SlaveFragment.newInstance(name))
        })

        nameAdapter.setItems(arrayListOf("Jake", "Roman", "Steven", "Harry", "Cristopher"))
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = nameAdapter
    }

    override fun onNotification(newName: String) {
        this.newName = newName
        if(isVisibleToUser) nameAdapter.replace(oldName, requireNotNull(newName))
        else; // do it when fragment become visible to user
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser && newName != null)  {
            nameAdapter.replace(oldName, requireNotNull(newName))
        }
    }
}