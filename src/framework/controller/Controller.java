package framework.controller;

import framework.externalInterfaces.IController;

public class Controller implements IController {

	private static Controller instance;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;

	}

	private Controller() {

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
