package com.train.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.train.service.IStationService;

@Controller
public class StationController {
	/**
	 * 点击变量名称按ctrl+shift+x
	 */
	private static Logger LOGGER = Logger.getLogger(StationController.class);
	/**
	 * 跳转到查询车票价格页面
	 */
	private static final String SHOWPRICE="showPrice";
	/**
     * 得到查询结果界面
     */
	private static final String GETPRICE="getPrice";
	/**
     * 404页面
     */
    private static final String EMPTY="empty";
	@Autowired
	private IStationService iStationService;
	/**
	 * 跳转到查询车票价格界面
	 * @return 
	 * 2016年11月25日
	 */
	@RequestMapping("/showPrice")
	public String showPrice(){
		return SHOWPRICE;
	}
	/**
	 * 
	 * @param trainnum
	 * @param startStation
	 * @param endStation
	 * @param request
	 * @return 
	 * 2016年11月25日
	 */
	@RequestMapping("/getPrice")
	public String getPrice(String trainnum,String startStation,String endStation,HttpServletRequest request){
		//####效验前端传入参数是否为空开始
		if(StringUtils.isEmpty(trainnum)){
			LOGGER.error("getPrice() trainnum is null ");
    		request.setAttribute("error","车次不能为空!");
    		return SHOWPRICE;
		}
		if(StringUtils.isEmpty(startStation)){
    		LOGGER.error("getPrice() startStation is null ");
    		request.setAttribute("error","出发站不能为空!");
    		return SHOWPRICE;
    	}
    	if(StringUtils.isEmpty(endStation)){
    		LOGGER.error("getPrice() endStation is null ");
    		request.setAttribute("error","终点站不能为空!");
    		return SHOWPRICE;
    	}
    	Double calcuSartToEndPrice = iStationService.calcuSartToEndPrice(trainnum, startStation, endStation);
    	//calcuSartToEndPrice如为空或者为0表示没有找到对应出行车次信息
    	if(calcuSartToEndPrice==null||calcuSartToEndPrice==0){
         	LOGGER.error("getPrice() calcuStarttoEndtinatPrice is null  ||calcuStarttoEndtinatPrice==0 ");
         	return EMPTY;
         }
    	 //车票价格参数
    	request.setAttribute("calcuSartToEndPrice",calcuSartToEndPrice);
		request.setAttribute("trainnum", trainnum);
		request.setAttribute("startStation",startStation);
		request.setAttribute("endStation",endStation);
    	//####效验前端传入参数是否为空结束
		return GETPRICE;
		
	}
}
