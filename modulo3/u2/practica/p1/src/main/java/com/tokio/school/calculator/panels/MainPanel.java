package com.tokio.school.calculator.panels;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.tokio.school.calculator.utils.OperationsUtils;

import lombok.Getter;

public class MainPanel extends PanelAbstract {
	enum OPERATION {
		ADD, SUBTRACT, DIVISION, MULTIPLY, EQUAL, FLOAT, FLOAT_ONLY
	};

	static Boolean INFINITE_BIG_DECIMAL = Boolean.FALSE; // Value doesn't matter

	private static final short N_COLS = 1;
	private static final short N_ROWS = 3;
	@Getter
	InputPanel inputPanel;
	@Getter
	protected ButtonGenericPanel buttonGenericPanel;
	private static BigDecimal result, salve, temp;
	private static OPERATION last_operation;

	public MainPanel() {
		confingPanel();
		initComponents();
		addEvents();
		temp = BigDecimal.ZERO;
		result = BigDecimal.ZERO;
		salve = BigDecimal.ZERO;
	}

	@Override
	void confingPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	void initComponents() {
		inputPanel = new InputPanel();
		add(inputPanel);

		buttonGenericPanel = new ButtonGenericPanel();
		add(buttonGenericPanel);
	}

	void addEvents() {
		Vector<JButton> vButton = buttonGenericPanel.getBottonNumericPanel().getVButtonNumeric();
		Vector<JButton> vButtonE = buttonGenericPanel.getBottonExtraPanel().getVBottonExtra();
		JTextField txtField = inputPanel.getTxtField();
		JLabel lblResult = inputPanel.getLbl();

		vButton.forEach(btn -> {
			btn.addActionListener(ae -> {
				String btnTxt = btn.getText();
				String aux;

				if (Boolean.TRUE.equals(INFINITE_BIG_DECIMAL)) {
					return;
				}
				aux = txtField.getText();
				switch (btnTxt.toLowerCase()) {
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					if (OperationsUtils.isNumeric(aux) && !OperationsUtils.isZero(aux) && last_operation == null) {
						aux += btn.getText();
					} else {
						if (!OperationsUtils.isZero(aux) && last_operation != null) {
							aux += btn.getText();
						} else {
							aux = btn.getText();
						}
					}
					txtField.setText(aux);
					break;
				case ".":
					if (last_operation == null) {
						if (!OperationsUtils.isNumeric(aux)) {
							aux = "0";
						}
						if (OperationsUtils.isStringADececimal(aux)) {
							temp = BigDecimal.ZERO;
							result = BigDecimal.ZERO;
							INFINITE_BIG_DECIMAL = Boolean.TRUE;
							txtField.setText("Infinite");
							lblResult.setText(txtField.getText());
						} else {
							txtField.setText(aux += OperationsUtils.POINT_DECIMAL);
						}
					} else {
						if (OperationsUtils.isStringADececimal(aux)) {
							temp = BigDecimal.ZERO;
							result = BigDecimal.ZERO;
							INFINITE_BIG_DECIMAL = Boolean.TRUE;
							txtField.setText("Infinite");
							lblResult.setText(txtField.getText());
						} else {
							txtField.setText(aux += OperationsUtils.POINT_DECIMAL);
						}
					}
					break;
				case "+":
					if (OperationsUtils.isNumeric(aux)) {
						temp = OperationsUtils.convertStringToBigDecimal(aux);
						result = OperationsUtils.add(result, temp);
					}
					printResutl(BigDecimal.ZERO, result);
					last_operation = OPERATION.ADD;
					break;
				case "-":
					if (OperationsUtils.isNumeric(aux)) {
						temp = OperationsUtils.convertStringToBigDecimal(aux);
						System.out.println(temp);
						result = OperationsUtils.subtract(result, temp);
					}
					printResutl(BigDecimal.ZERO, result);
					last_operation = OPERATION.SUBTRACT;
					break;
				case "*":
					if (OperationsUtils.isNumeric(aux)) {
						if (last_operation == null) {
							result = BigDecimal.ONE;
						}

						temp = OperationsUtils.convertStringToBigDecimal(aux);
						result = OperationsUtils.multiply(result, temp);
					}
					printResutl(BigDecimal.ZERO, result);
					last_operation = OPERATION.MULTIPLY;
					break;
				case "/":
					if (OperationsUtils.isNumeric(aux)) {
						if (last_operation == null) {
							result = OperationsUtils.convertStringToBigDecimal(aux);
							temp = OperationsUtils.convertStringToBigDecimal(aux);
						} else {
							temp = OperationsUtils.convertStringToBigDecimal(aux);
							// result = result.divide(temp, 4, RoundingMode.CEILING);
							BigDecimal resulAux = OperationsUtils.division(result, temp);
							if (Objects.isNull(resulAux)) {
								establishInfinite();
							} else {
								result = resulAux;
							}
						}
					}

					if (Boolean.TRUE.equals(INFINITE_BIG_DECIMAL)) {
						printResutl("Infinite", "Infinite");
					} else {
						printResutl(BigDecimal.ZERO.toString(), result.toString());
					}
					last_operation = OPERATION.DIVISION;
					break;
				case "=":
					if (last_operation == null) {
						if(!OperationsUtils.isDecimalZero(aux)) {
							result = new BigDecimal(0, MathContext.DECIMAL32);
						}else {
							result = new BigDecimal(aux, MathContext.DECIMAL32);	
						}
						
						printResutl(BigDecimal.ZERO, result);
						last_operation = OPERATION.EQUAL;
					}else {
						if(last_operation == OPERATION.EQUAL) {
							if(!OperationsUtils.isDecimalZero(aux)) {
								result = new BigDecimal(aux);
							}
							printResutl(result, result);
							last_operation = OPERATION.EQUAL;
						} else if (last_operation == OPERATION.ADD) {
							result = OperationsUtils.add(result,result);
							printResutl(result, result);
						} else if (last_operation == OPERATION.SUBTRACT) {
							result = OperationsUtils.subtract(result,result);
							printResutl(result, result);
						} else if (last_operation == OPERATION.MULTIPLY) {
							result = OperationsUtils.multiply(result,result);
							printResutl(result, result);
						} else if (last_operation == OPERATION.DIVISION) {
							if(!OperationsUtils.isDecimalZero(result.toString())) {
								result = OperationsUtils.division(result,result);
							}else {
								establishInfinite();
							}
							
							if (Boolean.TRUE.equals(INFINITE_BIG_DECIMAL)) {
								printResutl("Infinite", "Infinite");
							} else {
								printResutl(result, result);
							}
							
						}
					}					
					break;
				}
			});
		});

		vButtonE.forEach(btn -> btn.addActionListener(ae -> {
			String btnTxt = btn.getText();
			String aux = txtField.getText();
			
			switch (btnTxt.toLowerCase()) {
			case "c":
				// Limpia la caja de de texto de entrada
				txtField.setText(BigDecimal.ZERO.toString());
				break;
			case "limpiar":
				// Limpia todo
				clearAll();

				break;
			case "guardar":
				// Guarda el resultado, no el valor de la caja de texto, salvo que el resutado sea cero y la caja de texto no
				if(OperationsUtils.isDecimalZero(result.toString()) && !OperationsUtils.isDecimalZero(aux)) {
					result = new BigDecimal(aux);
				}
				
				salve = result;
				break;
			case "recuperar":
				// recupera el resultado
				if (Boolean.TRUE.equals(INFINITE_BIG_DECIMAL)) {
					txtField.setText("Infinite");
				} else {
					txtField.setText(salve.toString());
				}
				break;
			}
		}));
	}

	private void clearAll() {
		last_operation = null;
		result = BigDecimal.ZERO;
		salve = BigDecimal.ZERO;
		printResutl(BigDecimal.ZERO,result);
		INFINITE_BIG_DECIMAL = Boolean.FALSE;
	}
	
	private void printResutl(BigDecimal inputTxtField, BigDecimal inputResultLabel) {
		printResutl(inputTxtField.toString(), inputResultLabel.toString());

	}

	private void printResutl(String inputTxtField, String inputResultLabel) {
		JTextField txtField = inputPanel.getTxtField();
		JLabel lblResult = inputPanel.getLbl();

		txtField.setText(inputTxtField);
		lblResult.setText(inputResultLabel);
	}

	public static void establishInfinite() {
		temp = BigDecimal.ZERO;
		result = BigDecimal.ZERO;
		INFINITE_BIG_DECIMAL = Boolean.TRUE;
	}
}
