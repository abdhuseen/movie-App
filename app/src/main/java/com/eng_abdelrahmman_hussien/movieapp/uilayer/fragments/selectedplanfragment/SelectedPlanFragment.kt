package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.selectedplanfragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSelectedPlanBinding

class SelectedPlanFragment : Fragment() {
    private lateinit var selectedPlanBinding:FragmentSelectedPlanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        selectedPlanBinding=FragmentSelectedPlanBinding.inflate(inflater,container,false)
        selectedPlanBinding.lifecycleOwner=this
        return selectedPlanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val enjoyTextview=selectedPlanBinding.textviewEnjoy
        val planTypeTextview=selectedPlanBinding.textviewPlanType
        val img:ImageView=selectedPlanBinding.congrateImg
        img.setImageResource(R.drawable.congrats_gif)

        val enjoyScript="Enjoy an upgrade to Basic during\n" +
                "your first 30 days, free of charge. watch\n" +
                "in HD and on up to 2 screens at a time."
        enjoyTextview.text=enjoyScript
        planTypeTextview.text="Basic"
        val btn_thank=selectedPlanBinding.btnOkThanks
        //after user select subscription plan the layout of this fragment will shown to user to see congratulation message and the selected plan then can navigate using thanks button to sign-up fragment
        btn_thank.setOnClickListener {

            it.findNavController().navigate(R.id.action_selectedPlanFragment_to_signUpFragment)

        }

       }


}