import android.app.AlertDialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gost_app.Jelo
import com.example.gost_app.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class JeloAdapter(private val jelaList: List<Jelo>) :
    RecyclerView.Adapter<JeloAdapter.JeloViewHolder>() {

    class JeloViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nazivJela: TextView = itemView.findViewById(R.id.textView_naziv_jela)
        // Dodajte druge TextView-ove za ostale podatke jela ako je potrebno
        val opis: TextView = itemView.findViewById(R.id.textView_opis)
        val cijena: TextView = itemView.findViewById(R.id.textView_cijena)
        val button: Button = itemView.findViewById(R.id.jelo_button)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JeloViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.jelo_layout, parent, false)
        return JeloViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JeloViewHolder, position: Int) {
        val currentItem = jelaList[position]
        holder.nazivJela.text = currentItem.nazivJela
        holder.opis.text = currentItem.opis
        holder.cijena.text = currentItem.cijena.toString() + "0 KM"

        // Postavite ostale podatke jela u odgovarajuće TextView-ove
        holder.button.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            showPopup(holder.button.context, holder.button, jelaList[adapterPosition])
        }
    }
    private fun showPopup(context: Context, anchorView: View, selectedItem: Jelo) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val popupView: View = inflater.inflate(R.layout.popup_layout, null)
        var brojacJela : Int = 0

        // Pronađite elemente iz custom layouta
        val titleTextView: TextView = popupView.findViewById(R.id.textView_title)
        val contentTextView: TextView = popupView.findViewById(R.id.textView_content)
        val brojacText: TextView = popupView.findViewById(R.id.brojacTextView)
        val plusButton: FloatingActionButton = popupView.findViewById(R.id.plusButton)
        val minusButton: FloatingActionButton = popupView.findViewById(R.id.minusButton)
        val xButton: FloatingActionButton = popupView.findViewById(R.id.xButton)
        val okButton: Button = popupView.findViewById(R.id.okButton)

        // Postavite sadržaj prema podacima odabranog jela
        titleTextView.text = selectedItem.nazivJela
        contentTextView.text = selectedItem.opis
        brojacText.text = "1"

        plusButton.setOnClickListener{
            brojacJela++
            if(brojacJela <= 10)
            brojacText.text = brojacJela.toString()
            else brojacJela = 10

        }

        minusButton.setOnClickListener{
            brojacJela--
            if(brojacJela >= 0)
                brojacText.text = brojacJela.toString()
            else brojacJela = 0

        }



        // Postavite custom layout kao sadržaj AlertDialog-a
        alertDialogBuilder.setView(popupView)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()

        // Proračunaj poziciju dijaloga pored dugmeta
        val dialogWidth = alertDialog.window?.attributes?.width ?: 0
        val dialogHeight = alertDialog.window?.attributes?.height ?: 0
        val location = IntArray(2)
        anchorView.getLocationOnScreen(location)

        val x = location[0] //+ anchorView.width // pomeri dijalog desno od dugmeta
        val y = location[1] //+ anchorView.height // pomeri dijalog ispod dugmeta

        alertDialog.window?.attributes?.apply {
            gravity = Gravity.TOP or Gravity.START
            this.x = x
            this.y = y
            this.width = dialogWidth
            this.height = dialogHeight
        }


        alertDialog.show()
        xButton.setOnClickListener{
            alertDialog.dismiss()
        }

    }


    override fun getItemCount(): Int {
        return jelaList.size
    }





}
