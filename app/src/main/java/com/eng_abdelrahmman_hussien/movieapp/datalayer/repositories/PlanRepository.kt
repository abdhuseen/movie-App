package com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories

import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Plan

class PlanRepository {
  private  val subscription_plan_list=listOf(
    Plan(1,"Premium","JO5.99/month","4k\t\t\t\t\t4"),
    Plan(2,"Standard","JO7.99/month","HD\t\t\t\t\t2"),
    Plan(3,"Basic","JO3.99/month","SD\t\t\t\t\t1")
    )
     fun getPlans():List<Plan> = subscription_plan_list
}