package misiulia.alex.dev.detectfragmentsvisibility

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SlaveFragment : AppFragment() {
    companion object {
        val NAME = "name"

        fun newInstance(name: String) : Fragment{
            val bundle = Bundle()
            bundle.putString(NAME, name)
            val fragment = SlaveFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.slave_fragment_layout, container, false)

        val name = arguments.getString(NAME)
        val nameEditText = view.findViewById(R.id.name_edit_text) as EditText
        nameEditText.setText(name)

        val updateNameButton = view.findViewById(R.id.update_button) as Button
        updateNameButton.setOnClickListener {
            NotificationManager.next(nameEditText.text.toString())
        }

        return view
    }
}