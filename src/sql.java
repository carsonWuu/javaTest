
public class sql {
	public static void main(String [] args){
		for(int i=0;i<100;i++){
			String str1="create table iov_track_"+i+"(n_id int primary key auto_increment,c_model varchar(20),c_imei varchar(15),n_type tinyint,n_clng double,n_clat double,n_effect tinyint,n_lng double,n_lat double,n_satellite int,n_altitude double,n_accuracy float,n_bearing float,n_speed double,n_speed_2 double,n_distance double,n_gpstime double,c_token varchar(36),t_data_time datetime,t_create_time datetime);";
			String str2="alter table iov_track_"+i+" add index(c_imei,t_data_time);";
			System.out.println(str1);
			System.out.println(str2);
		}
	}
}
