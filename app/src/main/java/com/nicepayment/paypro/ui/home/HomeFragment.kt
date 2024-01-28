package com.nicepayment.paypro.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nicepayment.paypro.databinding.FragmentHomeBinding
import com.nicepayment.paypro.model.argument.PaymentArgument
import com.nicepayment.paypro.model.argument.PaymentMethod
import com.nicepayment.paypro.ui.payment.PaymentActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val button: Button = binding.button
        button.setOnClickListener{
           val intent  = Intent(requireActivity(), PaymentActivity::class.java)
            startActivity(intent)

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}