class Solution {
    class Car {
        int position;
        int speed;
        float trt;

        public Car(int position, int speed, float trt) {
            this.position = position;
            this.speed = speed;
            this.trt = trt;
        }

    }
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i], (float) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a.position));
        Stack<Car> stack = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            if(stack.isEmpty()){
                stack.push(cars[i]);
            }else{
                if(cars[i].trt > stack.peek().trt ){
                    stack.push(cars[i]);
                }
            }



        }

        return stack.size();
    }
}
