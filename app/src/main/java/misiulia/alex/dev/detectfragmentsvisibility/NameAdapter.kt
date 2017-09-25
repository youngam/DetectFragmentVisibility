package misiulia.alex.dev.detectfragmentsvisibility

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NameAdapter(private val onNameClick: (String) -> Unit): RecyclerView.Adapter<NameAdapter.NameViewHolder>() {
    lateinit var names: ArrayList<String>

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.name_item_view_layout, parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.setName(names[position])
    }

    fun setItems(names:ArrayList<String>) {
        this.names =  names
        notifyDataSetChanged()
    }


    inner class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.name_text_view) as TextView

        init {
            view.setOnClickListener {
                onNameClick(names[layoutPosition])
            }
        }

        fun setName(name: String) {
            nameTextView.text = name
        }
    }

    fun  replace(oldName: String, newName: String) {
        val oldNameIndex = names.indexOf(oldName)
        names[oldNameIndex] = newName
        notifyItemChanged(oldNameIndex)
    }
}