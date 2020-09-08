package com.yamba.android.presentation.fragmentdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.yamba.android.R

class ProgressbarDialogFragment : DialogFragment() {
    private var content: String? = null

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString("content")

        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style,theme)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater?.inflate(R.layout.progressdialogfragment,container,false)

        return view
    }

    companion object {
        fun newInstance(content:String) : ProgressbarDialogFragment {
            val f =
                ProgressbarDialogFragment()

            val args = Bundle()
            args.putString("content",content)
            f.arguments = args
            return f
        }
    }

}
