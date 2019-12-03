package fabricio.jefferson.recyclerviewgmail

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import fabricio.jefferson.recyclerviewgmail.model.Email
import kotlinx.android.synthetic.main.email_item.view.*

class EmailAdapter(val emails: MutableList<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>()  {

    inner class EmailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(email: Email) {
            with(email) {
                val hash = user.hashCode()
                itemView.txt_icon.text = user.first().toString()
                itemView.txt_icon.background = itemView.oval(Color.rgb(hash, hash /2, 0))
                itemView.txt_user.text = user
                itemView.txt_subject.text = subject
                itemView.txt_preview.text = preview
                itemView.txt_date.text = date

                itemView.txt_user.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
                itemView.txt_subject.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
                itemView.txt_date.setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

                itemView.img_star.setImageResource(
                    if (stared) R.drawable.ic_star_black_24dp
                    else R.drawable.ic_star_border_black_24dp
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval

}