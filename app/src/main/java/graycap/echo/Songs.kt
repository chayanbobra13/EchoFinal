package graycap.echo

import android.os.Parcel
import android.os.Parcelable

class Songs(var songId: Long, var songTitle: String, var artist: String
            , var songData: String , var dataAdded: Long):Parcelable {



    object Statified {
        var nameComparator: Comparator<Songs> = Comparator<Songs>{song1, song2 ->
            val songOne = song1.songTitle.toUpperCase()
            val songTwo = song2.songTitle.toUpperCase()
            songOne.compareTo(songTwo)
        }

        var dateComparator:Comparator<Songs> = Comparator<Songs>{ song1, song2 ->
            val songone = song1.dataAdded.toDouble()
            val songTwo = song2.dataAdded.toDouble()
            songone.compareTo(songone)
        }
    }
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong()) {
    }
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO()
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Songs> {
        override fun createFromParcel(parcel: Parcel): Songs {
            return Songs(parcel)
        }

        override fun newArray(size: Int): Array<Songs?> {
            return arrayOfNulls(size)
        }
    }


}