package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.setupcreditFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSetupCreditBinding

class SetupCreditFragment : Fragment() {
private lateinit var setupCreditBinding:FragmentSetupCreditBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupCreditBinding=FragmentSetupCreditBinding.inflate(inflater,container,false)
        setupCreditBinding.lifecycleOwner=this
        return setupCreditBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_start_membership=setupCreditBinding.btnStartMemberShip

        //after user setup his credit card payment method it will navigate to login fragment by start membership button
        btn_start_membership.setOnClickListener {
          it.findNavController().navigate(R.id.action_setupCreditFragment_to_loginFragment2)
        }
    }

}