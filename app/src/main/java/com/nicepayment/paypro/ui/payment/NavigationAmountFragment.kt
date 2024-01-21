package com.nicepayment.paypro.ui.payment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.nicepayment.paypro.R
import com.nicepayment.paypro.databinding.FragmentHomeBinding
import com.nicepayment.paypro.databinding.FragmentNavigationAmountBinding

class NavigationAmountFragment : Fragment() {
    private var _binding: FragmentNavigationAmountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationAmountBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root
        val viewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        val next: Button = _binding!!.next

        next.setOnClickListener {
            Log.e("Model","next")
            viewModel.setAmount(_binding!!.editTextAmount.text.toString())

            findNavController().navigate(R.id.action_navigationAmountFragment_to_navigationCodeFragment)
        }



        return root
    }


}