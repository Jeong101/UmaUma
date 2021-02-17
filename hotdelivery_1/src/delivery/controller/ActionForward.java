package delivery.controller;


import delivery.cart.action.PlusMoneyAction;
import delivery.cart.action.RegistCartAction;
import delivery.cart.action.ShowCartListAction;
import delivery.member.action.Action;
import delivery.member.action.DeleteMemberAction;
import delivery.member.action.FindIdAction;
import delivery.member.action.FindPwdAction;
import delivery.member.action.LoginAction;

import delivery.member.action.RegistMemberAction;

import delivery.member.action.UpdateMemberAction;
import delivery.store.action.StoreListAction;
import delivery.worldcup.action.FoodFindAction;
import delivery.worldcup.action.WinNoAction_8;
import delivery.worldcup.action.WorldCupAction;

public class ActionForward {
	
	public ActionForward() {
		
	}

	public Action getAction(String command) {
		Action action = null;
		
		// 게시판의 리스트를 보여주기 위한 처리 작업
		if(command.equals("regist")){
			action = new RegistMemberAction();
		}
		if(command.equals("login")) {
			action = new LoginAction();
		}		
		if(command.equals("udpateMember")) {
			action = new UpdateMemberAction();
		}
		if(command.equals("deleteMember")) {
			action = new DeleteMemberAction();
		}
		
		if(command.equals("worldCup")) {
			action = new WorldCupAction();
		}
		if(command.equals("winNo")){
			action = new WinNoAction_8();
		}
		if(command.equals("findId")) {
			action = new FindIdAction();
		}
		if(command.equals("findPwd")) {
			action = new FindPwdAction();
		}
		if(command.equals("foodFind")){
			action = new FoodFindAction();
		}		
		if(command.equals("kfood")){
			action = new StoreListAction();
		}
		if(command.equals("cfood")){
			action = new StoreListAction();
		}
		if(command.equals("jfood")){
			action = new StoreListAction();
		}
		if(command.equals("wfood")){
			action = new StoreListAction();
		}
		if(command.equals("outpay")){
			action = new payment();
		}
		if(command.equals("registCart")) {
			action= new RegistCartAction();
		}
		if(command.equals("cartList")){
			action= new ShowCartListAction();
		}
		if(command.equals("plusMoney")){
			action = new PlusMoneyAction();
		}
		return action;
	}
}
