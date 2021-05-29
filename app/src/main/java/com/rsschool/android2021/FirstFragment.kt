package com.rsschool.android2021

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


class FirstFragment : Fragment() {

    private var generateButton: Button? = null
    private var previousResult: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        // TODO: val min = ...
        // TODO: val max = ...
        val min: EditText? = view.findViewById(R.id.min_value)
        val max: EditText? = view.findViewById(R.id.max_value)

        generateButton?.setOnClickListener {

            // TODO: send min and max to the SecondFragment
            if(min?.getText().toString().equals("") || max?.getText().toString().equals("") ){
                Toast.makeText(activity,"Invalid data",Toast.LENGTH_SHORT).show()
            }else {
                val maxInt = max?.text.toString().toInt()
                val minInt = min?.text.toString().toInt()

                if(maxInt <= minInt) {

                    /*val dialogBuilder = activity?.let { it1 -> AlertDialog.Builder(it1) }
                    val alert = dialogBuilder?.create()
                    alert?.setTitle("Invalid Data")
                    alert?.show()*/
                        Toast.makeText(activity, "Invalid data", Toast.LENGTH_LONG).show()
                }else {
                    val secondFragment = SecondFragment.newInstance(minInt, maxInt)
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.container, secondFragment)
                    transaction.commit()
                }
            }
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }
}