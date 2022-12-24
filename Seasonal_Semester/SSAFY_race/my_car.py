from DrivingInterface.drive_controller import DrivingController
import math


class DrivingClient(DrivingController):
    def __init__(self):
        # =========================================================== #
        #  Area for member variables =============================== #
        # =========================================================== #
        # Editing area starts from here
        #

        self.is_debug = False

        #
        # Editing area ends
        # ==========================================================#
        super().__init__()

    def control_driving(self, car_controls, sensing_info):

        # =========================================================== #
        # Area for writing code about driving rule ================= #
        # =========================================================== #
        # Editing area starts from here
        #

        if self.is_debug:
            print("=========================================================")
            print("[MyCar] to middle: {}".format(sensing_info.to_middle))

            print("[MyCar] collided: {}".format(sensing_info.collided))
            print("[MyCar] car speed: {} km/h".format(sensing_info.speed))

            print("[MyCar] is moving forward: {}".format(sensing_info.moving_forward))
            print("[MyCar] moving angle: {}".format(sensing_info.moving_angle))
            print("[MyCar] lap_progress: {}".format(sensing_info.lap_progress))

            print("[MyCar] track_forward_angles: {}".format(sensing_info.track_forward_angles))
            print("[MyCar] track_forward_obstacles: {}".format(sensing_info.track_forward_obstacles))
            print("[MyCar] opponent_cars_info: {}".format(sensing_info.opponent_cars_info))
            print("[MyCar] distance_to_way_points: {}".format(sensing_info.distance_to_way_points))
            print("=========================================================")

        ###########################################################################

        # Moving straight forward
        car_controls.steering = 0
        car_controls.throttle = 1
        car_controls.brake = 0

        # Moving straight forward
        # 초기 세팅 값
        # steering=1 => +50도 <=> 1도 변경을 위해서는 0.02씩 변경해야 함
        car_controls.steering = 0
        car_controls.throttle = 1
        car_controls.brake = 0

        # 1. 10개의 waypoint까지의 거리와 갈 수 있는지 여부를 담는 배열 생성
        # road_dist_array = []
        # road_possible_array = []

        road_max_dist = -1
        road_max_angle = 0

        for i in range(10):
            distance = sensing_info.distance_to_way_points[i]
            angle = sensing_info.track_forward_obstacles[i]

            if abs(angle) <= 50:
                if road_max_dist <= distance:
                    road_max_dist = distance
                    road_max_angle = angle

            # 현재 위치에서 해당 포인트까지의 높이
            height_to_middle = distance * math.cos(math.radians(angle))
            # 현재 위치에서 해당 포인트까지의 밑변
            base_to_middle = distance * math.sin(math.radians(angle))

            for j in range(2):
                tmp_left_base = abs(base_to_middle - (j * 2))
                tmp_left_angle = math.degrees(math.atan(float(tmp_left_base / height_to_middle))) * (-1)
                tmp_left_dist = math.sqrt(math.pow(height_to_middle, 2) + math.pow(tmp_left_base, 2))
                tmp_right_base = abs(base_to_middle + (j * 2))
                tmp_right_angle = math.degrees(math.atan(float(tmp_right_base / height_to_middle)))
                tmp_right_dist = math.sqrt(math.pow(height_to_middle, 2) + math.pow(tmp_right_base, 2))

                # 좌측부터 시작
                if tmp_left_angle <= 50:
                    if road_max_dist < tmp_left_dist :
                        road_max_dist = tmp_left_dist
                        road_max_angle = tmp_left_angle

                # 우측도 시작
                if tmp_right_angle <= 50:
                    if road_max_dist < tmp_right_dist :
                        road_max_dist = tmp_left_dist
                        road_max_angle = tmp_right_angle

        car_controls.steering = road_max_angle * 0.02
        car_controls.throttle = distance / 100
        car_controls.brake = 5 / distance

        if self.is_debug:
            print("[MyCar] steering:{}, throttle:{}, brake:{}" \
                  .format(car_controls.steering, car_controls.throttle, car_controls.brake))

        #
        # Editing area ends
        # ==========================================================#
        return car_controls

    # ============================
    # If you have NOT changed the <settings.json> file
    # ===> player_name = ""
    #
    # If you changed the <settings.json> file
    # ===> player_name = "My car name" (specified in the json file)  ex) Car1
    # ============================
    def set_player_name(self):
        player_name = ""
        return player_name


if __name__ == '__main__':
    print("[MyCar] Start Bot!")
    client = DrivingClient()
    return_code = client.run()
    print("[MyCar] End Bot!")

    exit(return_code)