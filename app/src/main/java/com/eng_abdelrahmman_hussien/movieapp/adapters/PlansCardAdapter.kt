package com.eng_abdelrahmman_hussien.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Plan
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class PlansCardAdapter(private val plansList:List<Plan>):RecyclerView.Adapter<PlansCardAdapter.PlansCardViewHolder>() {
//fill each plan data in plan card
    inner class PlansCardViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val txt_planType:MaterialTextView=itemView.findViewById(R.id.textview_planType)
        val txt_planPrice:MaterialTextView=itemView.findViewById(R.id.textview_plan_price)
        val txt_planResolution:MaterialTextView=itemView.findViewById(R.id.textview_plan_resolution)
        val btn_select:MaterialButton=itemView.findViewById(R.id.btn_select)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlansCardViewHolder {
        return PlansCardViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.plan_card,parent,false)))
    }

    override fun getItemCount():Int{

        return plansList.size
    }

    override fun onBindViewHolder(holder: PlansCardViewHolder, position: Int) {
        holder.txt_planType.text=plansList[position].typeProp
        holder.txt_planPrice.text=plansList[position].priceProp
        holder.txt_planResolution.text=plansList[position].resolutionProp
        holder.btn_select.setOnClickListener {
            Toast.makeText(holder.txt_planPrice.context,"You Select ${plansList[position].typeProp}",Toast.LENGTH_SHORT).show()
            it.findNavController().navigate(R.id.action_choosePlanFragment_to_selectedPlanFragment)
        }

    }
}