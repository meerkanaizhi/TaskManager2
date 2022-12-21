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
        OnBoard("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyWfRfRY9bzWXScTFAZcUqgltp5sXm3pgOMg&usqp=CAU", "Americano coffee"),
        OnBoard("data:image/jpeg;base64,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", "Ice coffee"),
        OnBoard("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKEypWBBin9UFsjHURA8X9HvLX706ifyCE0A&usqp=CAU", "Latte coffee")

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

          Glide.with(binding.ivBoarding).load(onBoard.image).into(binding.ivBoarding)

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