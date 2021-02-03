package cn.itcast.service;

import org.springframework.stereotype.Service;

@Service
public class ActionService {
    public void say() {
        System.out.println("说话");

    }

    public double getowemoney() {
        double sum = (19992.39 + 1949.95 + 6 * 176.62);
        return sum;
    }

}
