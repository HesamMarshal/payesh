package ir.hesammarshal.payesh.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeartItems (
    @ColumnInfo(name = "heart_date") val heartDate: String,
    @ColumnInfo(name = "heart_time") val heartTime: String,
    @ColumnInfo val systolic: String,
    @ColumnInfo val diastolic: String,
    @ColumnInfo val pulse: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
