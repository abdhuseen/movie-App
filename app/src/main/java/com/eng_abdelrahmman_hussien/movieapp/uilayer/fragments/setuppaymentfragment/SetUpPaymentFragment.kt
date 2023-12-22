package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.setuppaymentfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSetUpPaymentBinding

class SetUpPaymentFragment : Fragment() {
    private lateinit var setupPaymentBinding:FragmentSetUpPaymentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupPaymentBinding=FragmentSetUpPaymentBinding.inflate(inflater,container,false)
        setupPaymentBinding.lifecycleOwner=this
        return setupPaymentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //here user will choose payment method each button here represent payment methods available in the app
        //when user click the payment button he will navigate to the setup fragment for these method
        val btn_setup_credit=setupPaymentBinding.btnCredit
        val btn_setup_paypal=setupPaymentBinding.btnPaypal
        btn_setup_credit.setOnClickListener {
            it.findNavController().navigate(R.id.action_setUpPaymentFragment_to_setupCreditFragment)
        }
        btn_setup_paypal.setOnClickListener {
            it.findNavController().navigate(R.id.action_setUpPaymentFragment_to_setUpPaypalFragment)
        }
    }

}