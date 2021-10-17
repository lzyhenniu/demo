package com.company;

import com.pojo.OrderItem;
import com.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class showDataservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> book = new HashMap<String, Object>();
        book.put("ISBN", "519");
        book.put("price", 103.2);
        book.put("press", "广东省出版社");

        HashMap<String, String> address = new HashMap<String, String>();
        address.put("province", "广东省");
        address.put("city", "广州市");
        address.put("dinst", "从化区");
        book.put("addr", address);
//用request对象进行封装和传递
        req.setAttribute("book", book);

//用session对象进行封装和传递
        req.getSession().setAttribute("book1", book);
//空集合，一边生成购物详情，一边添加购物详情到购物详情列表中
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        Product product;
        OrderItem orderItem;
        for (int i = 0; i < 0; i++){
            orderItem=new OrderItem();
            orderItem.setId(100+i);
            orderItem.setNum(10*i);


//生成商品
            product = new Product();
//填充商品
            product.setPrice(10+i);
            product.setName("商品名" + i);
            product.setDesc("商品描述" + i);
            product.setId(5000+i);
            product.setImgUrl("xh"+i+".png");
//          商品详情中填充商品信息
            orderItem.setProduct(product);

            //将商品详情添加到列表
            orderItems.add(orderItem);
    }
    //用session封装和传递购物详情数据
        req.getSession().setAttribute("orderItem", orderItems);

        req.getRequestDispatcher("showData.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
