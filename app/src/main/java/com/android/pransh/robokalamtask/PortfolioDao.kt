package com.android.pransh.robokalamtask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PortfolioDao {
    @Insert
    suspend fun insertPortfolio(portfolio: Portfolio)

    @Query("SELECT * FROM portfolio LIMIT 1")
    suspend fun getPortfolio(): Portfolio?
}