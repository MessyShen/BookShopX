package com.book.action;

import com.book.entity.Books;
import com.book.entity.CartItemBean;
import com.book.service.BookInfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.Map;

public class CartAction extends ActionSupport implements SessionAware {
    private Integer booksId;

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int quantity;

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    BookInfoService bookInfoService;

    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    //将商品信息添加至购物车
    public String addtoshopcart(){
        //从Session中取出购物车，放入Map对象的cart中
        Map cart=(Map)session.get("cart");
        //获取当前要添加至购物车的商品
        Books book = bookInfoService.getBookInfoById(booksId);
        //如果购物车不存在，则创建购物车（实例化HashMap类），并存入到session中
        if (cart==null) {
            cart=new HashMap();
            session.put("cart", cart);
        }
        //如果存在购物车，则判断要添加的商品是否已在购物车中
        CartItemBean cartItem=(CartItemBean)cart.get(book.getId());
        if (cartItem!=null) {
            //如果商品在购物车中，只要更新其数量
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }else {
            //否则，创建一个商品条目至购物车中
            cart.put(book.getId(), new CartItemBean(book, 1));
        }
        //页面跳转到cart.jsp，x显示购物车
        return "shopCart";
    }

    public String updateSelectedQuantity(){
        //从session取出购物车，放入Map对象cart中
        Map cart=(Map)session.get("cart");
        CartItemBean cartItem=(CartItemBean)cart.get(booksId);
        cartItem.setQuantity(quantity);
        return "shopCart";
    }


    public String deleteSelectedOrders(){
        //从session取出购物车，放入Map对象cart中
        Map cart=(Map)session.get("cart");
        cart.remove(booksId);
        return "shopCart";
    }

    public String clearCart(){
        //从session取出购物车，放入Map对象cart中
        Map cart=(Map)session.get("cart");
        cart.clear();
        return "shopCart";
    }


}
