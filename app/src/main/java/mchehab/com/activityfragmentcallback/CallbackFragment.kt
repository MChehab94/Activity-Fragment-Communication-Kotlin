package mchehab.com.activityfragmentcallback


import android.os.Bundle
import android.app.Fragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


/**
 * A simple [Fragment] subclass.
 */
class CallbackFragment : Fragment() {

    lateinit var callbackFragment: FragmentListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_callback, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener{
            callbackFragment.answerFragment("Fragment Button Clicked")
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is FragmentListener){
            callbackFragment = context
            callbackFragment.answerFragment("Inside onAttach")
        }
    }

    override fun onDetach() {
        super.onDetach()
        callbackFragment.answerFragment("Fragment about to detach!")
    }

}// Required empty public constructor
