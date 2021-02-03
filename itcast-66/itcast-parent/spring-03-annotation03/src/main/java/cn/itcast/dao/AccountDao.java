package cn.itcast.dao;
//数据层数据操作接口
public interface AccountDao {

    public void in(String inCount,Double money);

    public void out(String outCount,Double money);


}
