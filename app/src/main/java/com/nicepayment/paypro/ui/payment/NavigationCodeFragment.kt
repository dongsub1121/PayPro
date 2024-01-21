package com.nicepayment.paypro.ui.payment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nicepayment.paypro.R
import com.nicepayment.paypro.databinding.FragmentNavigationAmountBinding
import com.nicepayment.paypro.databinding.FragmentNavigationCodeBinding

class NavigationCodeFragment : Fragment() {
    private var _binding: FragmentNavigationCodeBinding? = null

    private val binding get() = _binding!!
    private lateinit var barcode: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationCodeBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root
        val viewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        val next: Button = _binding!!.next

        next.setOnClickListener {
            Log.e("Model","next")
            barcode = _binding!!.editTextAmount.text.toString()
            viewModel.setAmount(barcode)
            findNavController().navigate(R.id.action_navigationCodeFragment_to_navigationLoadingStateFragment)
        }

        return root
    }


}