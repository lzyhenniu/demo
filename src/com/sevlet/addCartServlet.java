package com.sevlet;

import com.pojo.OrderItem;
import com.pojo.Product;
import com.service.impl.DataServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class addCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream(),"utf-8"));
        StringBuffer sb=new StringBuffer();
        String temp;
        while ((temp=br.readLine()) !=null){
            sb.append(temp);

        }

        String Str_id=sb.toString().split("=")[1];

        int id=Integer.parseInt(Str_id);
        Product product=DataServicelmpl.findById(id);
      //  System.out.println(product);

        HttpSession session=req.getSession();
        OrderItem orderItem;
        HashMap<Integer,OrderItem> cart=(HashMap<Integer,OrderItem>)session.getAttribute("cart");
        if(cart==null){
            cart=new  HashMap<Integer,OrderItem>();

        }
        orderItem=cart.get(product.getId());
        if (orderItem==null){
            orderItem=new OrderItem();
            orderItem.setProduct(product);
            orderItem.setNum(1);

        }else {
            orderItem.setNum(orderItem.getNum()+1);
        }
        cart.put(product.getId(),orderItem);
        session.setAttribute("cart",cart);

        System.out.println(cart);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
