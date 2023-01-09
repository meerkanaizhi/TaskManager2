package kg.geektech.taskmanager.ui.onBoarding.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import kg.geektech.taskmanager.R
import kg.geektech.taskmanager.databinding.ItemBoardingBinding
import kg.geektech.taskmanager.model.OnBoard



class OnBoardingAdapter (private val context: Context, private val onClick: ()-> Unit): RecyclerView.Adapter<OnBoardingAdapter.onBoardingViewHolder>() {

    private val data = arrayListOf<OnBoard>(
        OnBoard(R.raw.taskmanager, "Control your tasks"),
        OnBoard(R.raw.copvtimemanager, "Convienment time management"),
        OnBoard(R.raw.busypeople, "For busy people")

    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemBoardingBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class onBoardingViewHolder (private val binding: ItemBoardingBinding):
        RecyclerView.ViewHolder(binding.root){


        fun bind(onBoard: OnBoard) {

      //    Glide.with(binding.ivBoarding).load(onBoard.image).into(binding.ivBoarding)
            binding.ivBoarding.setAnimation(onBoard.image)
            binding.tvTitle.text = onBoard.titles
            if (adapterPosition == data.lastIndex) {
                binding.tvSkip.text = context.getString(R.string.next)
            }else  binding.tvSkip.text = context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }


        }

    }

}
