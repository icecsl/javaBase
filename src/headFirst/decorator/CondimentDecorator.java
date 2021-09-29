package headFirst.decorator;

/**
 * 调料装饰者类
 */
public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	@Override
	public abstract String getDescription();
}
