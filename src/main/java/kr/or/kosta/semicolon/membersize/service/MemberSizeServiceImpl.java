package kr.or.kosta.semicolon.membersize.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.bottom.service.BottomService;
import kr.or.kosta.semicolon.common.Clothing;
import kr.or.kosta.semicolon.membersize.dao.MemberSizeDao;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;
import kr.or.kosta.semicolon.tops.domain.Tops;
import kr.or.kosta.semicolon.tops.service.TopsService;

@Service
public class MemberSizeServiceImpl implements MemberSizeService {
	Logger logger = Logger.getLogger(MemberSizeServiceImpl.class);
	
	@Inject
	MemberSizeDao sizeDao;
	
	@Inject
	TopsService topsService;
	
	@Inject
	BottomService bottomService;
	
	@Override
	public int insert(MemberSize size) {
		return sizeDao.insert(size);
	}

	@Override
	public MemberSize select(int no) {
		return sizeDao.select(no);
	}

	@Override
	public int update(MemberSize size) {
		return sizeDao.update(size);
	}

	@Override
	public void delete(int no) {
		sizeDao.delete(no);
	}

	@Override
	public List<MemberSize> listAll() {
		return sizeDao.listAll();
	}
	
	@Override
	/**
	 * <pre>
	 * 1. 개       요 : 최적의 사이즈를 찾아 차를 반환
	 * 2. 처 리 내 용 : membersize와 상품size를 비교하여 최적의 size를 찾은 뒤 두 값의 차를 저장하여 반환한다.
	 * </pre>
	 * @Method Name : compare
	 * @param goods : bottom 또는 tops의 리스트
	 * @param size : membersize
	 * @return Clothing
	 */
	public Clothing compare(List<? extends Clothing> goods, MemberSize size) {
		int min = 1000; //임의의 값
		int sum = 0; //사이즈 차의 합
		Clothing minObj = null; 
		
		logger.debug("compare[tops:"+goods+",size:"+size+"]");
		
		for (Object object : goods) {
			sum = 0;
			
			if(object instanceof Tops) {
				logger.debug("tops:"+object);
				sum += ((Tops) object).getSleeveLength() - size.getSleeve(); 
				sum += ((Tops) object).getFullLength() - size.getTop(); 
			}else {
				sum += ((Bottom)object).getFullLength() - size.getPants();
				sum += ((Bottom)object).getHip() - size.getHip()*2;
				sum += ((Bottom)object).getRise() - size.getRise();
				sum += ((Bottom)object).getThigh() - size.getThigh();
				sum += ((Bottom)object).getWaist() - size.getWaist()*2;
			}
			
			logger.debug("sum:"+sum);
			
			//sum 중 가장 작은 값을 구함
			if(min > sum) {
				if(sum > -5  && sum <20) {
					min = sum;
					if(object instanceof Tops) {
						minObj = new Tops();
						((Tops) minObj).setSleeveLength(((Tops) object).getSleeveLength() - size.getSleeve());
						((Tops) minObj).setFullLength(((Tops) object).getSleeveLength() - size.getSleeve());
						((Tops) minObj).setSizes(((Tops) object).getSizes());
						((Tops) minObj).setTypes(((Tops)object).getTypes());
					}
					else {
						minObj = new Bottom();
						((Bottom)minObj).setFullLength(((Bottom)object).getFullLength() - size.getPants());
						((Bottom)minObj).setHip(((Bottom)object).getHip() - size.getHip()*2);
						((Bottom)minObj).setRise(((Bottom)object).getRise() - size.getRise());
						((Bottom)minObj).setThigh(((Bottom)object).getThigh() - size.getThigh());
						((Bottom)minObj).setWaist(((Bottom)object).getWaist() - size.getWaist()*2);
						((Bottom)minObj).setSizes(((Bottom)object).getSizes());
						((Bottom)minObj).setTypes(((Bottom)object).getTypes());
					}
				}// end middle if
			}//end outer if
		}//end for
		
		return minObj;
	}
	
	@Override
	/**
	 * <pre>
	 * 1. 개       요 : membersize와 tops 또는 bottom 의 차
	 * 2. 처 리 내 용 : membersize와 tops 또는 bottom 의 차를 구하여 반환한다.
	 * </pre>
	 * @Method Name : getGap
	 * @param cloth : bottom 또는 tops
	 * @param size : membersize
	 * @return Clothing
	 */
	public Clothing getGap(Clothing cloth, MemberSize size) {
		
		Clothing rsCloth = null;
		
		if(cloth instanceof Tops) {
			rsCloth = new Tops();
			((Tops) rsCloth).setSleeveLength(((Tops) cloth).getSleeveLength() - size.getSleeve());
			((Tops) rsCloth).setFullLength(((Tops) cloth).getSleeveLength() - size.getSleeve());
			((Tops) rsCloth).setSizes(((Tops) cloth).getSizes());
			((Tops) rsCloth).setTypes(((Tops)cloth).getTypes());
		}
		else {
			rsCloth = new Bottom();
			((Bottom)rsCloth).setFullLength(((Bottom)cloth).getFullLength() - size.getPants());
			((Bottom)rsCloth).setHip(((Bottom)cloth).getHip() - size.getHip()*2);
			((Bottom)rsCloth).setRise(((Bottom)cloth).getRise() - size.getRise());
			((Bottom)rsCloth).setThigh(((Bottom)cloth).getThigh() - size.getThigh());
			((Bottom)rsCloth).setWaist(((Bottom)cloth).getWaist() - size.getWaist()*2);
			((Bottom)rsCloth).setSizes(((Bottom)cloth).getSizes());
			((Bottom)rsCloth).setTypes(((Bottom)cloth).getTypes());
		}
		
		return rsCloth;
	}

}
