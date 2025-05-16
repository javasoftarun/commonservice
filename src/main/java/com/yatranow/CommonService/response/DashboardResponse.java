package com.yatranow.CommonService.response;

public class DashboardResponse {
    private long totalUsers;
    private double totalProfit;
    private long totalBookings;
    private long pendingBookings;
    private long canceledBookings;
    private long totalCabs;
    private long activeCabs;
    private long inactiveCabs;

	public DashboardResponse(long totalUsers, double totalProfit, long totalBookings, long pendingBookings,
			long canceledBookings, long totalCabs, long activeCabs, long inactiveCabs) {
		this.totalUsers = totalUsers;
		this.totalProfit = totalProfit;
		this.totalBookings = totalBookings;
		this.pendingBookings = pendingBookings;
		this.canceledBookings = canceledBookings;
		this.totalCabs = totalCabs;
		this.activeCabs = activeCabs;
		this.inactiveCabs = inactiveCabs;
	}
	public long getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	public long getTotalBookings() {
		return totalBookings;
	}
	public void setTotalBookings(long totalBookings) {
		this.totalBookings = totalBookings;
	}
	public long getPendingBookings() {
		return pendingBookings;
	}
	public void setPendingBookings(long pendingBookings) {
		this.pendingBookings = pendingBookings;
	}
	public long getCanceledBookings() {
		return canceledBookings;
	}
	public void setCanceledBookings(long canceledBookings) {
		this.canceledBookings = canceledBookings;
	}
	public long getTotalCabs() {
		return totalCabs;
	}
	public void setTotalCabs(long totalCabs) {
		this.totalCabs = totalCabs;
	}
	public long getActiveCabs() {
		return activeCabs;
	}
	public void setActiveCabs(long activeCabs) {
		this.activeCabs = activeCabs;
	}
	public long getInactiveCabs() {
		return inactiveCabs;
	}
	public void setInactiveCabs(long inactiveCabs) {
		this.inactiveCabs = inactiveCabs;
	}
}

