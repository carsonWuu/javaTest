package test.str;

public class strign {
	public static void main(String []args){
		for(int i=0;i<100;i++){
			String temp="INSERT INTO iov_track_"+i+" (c_imei,n_clng,n_clat,n_lat,n_lng,t_data_time) select c_imei,n_clng,n_clat,n_lat,n_lng,t_data_time from iov_track_"+i+";";
			System.out.println(temp);
		}
	}
}
