package cn.itcast.dao;

public interface AccountDao {
    //数据层出账抽象方法
    public void out(String outCount,Double money);

    //数据层进账抽象方法
    public void in(String inCount,Double money);
}
