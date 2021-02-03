package cn.itcast.dao;

public interface AccountDao {
    //创建进账抽象方法
    public void in(String inCount,Double money);
    //创建出账抽象方法
    public void out(String outCount,Double money);
}
